/**
 * This file is part of the @iconify/iconify package.
 *
 * (c) Vjacheslav Trushkin <cyberalien@gmail.com>
 *
 * For the full copyright and license information, please view the license.txt or license.gpl.txt
 * files that were distributed with this source code.
 *
 * Licensed under Apache 2.0 or GPL 2.0 at your option.
 * If derivative product is not compatible with one of licenses, you can pick one of licenses.
 *
 * @license Apache 2.0
 * @license GPL 2.0
 */

/**
 * Build tests
 */
"use strict";

const fs = require('fs'),
    path = require('path'),
    glob = require('glob'),
    Helper = require('./_helper');

let sourceDir = 'tests',
    targetDir = 'debug',
    codeDir = 'src',
    tests = [];

let resolvedSourceDir = path.resolve(__dirname, '../' + sourceDir),
    resolvedTargetDir = path.resolve(__dirname, '../' + targetDir),
    resolvedCodeDir = path.resolve(__dirname, '../' + codeDir);

/**
 * Helper functions for test builders
 */
let TestHelper = {
    replace: (content, search, replace, error) => {
        if (content.indexOf(search) === -1) {
            throw new Error(error);
        }
        return content.replace(search, replace);
    },

    // Get common/prefix.js
    getPrefix: () => {
        return '(function (local) {\n' +
            fs.readFileSync(resolvedCodeDir + '/common/prefix.js', 'utf8')
                .replace('module.exports = getPrefix;', 'local.getPrefix = getPrefix;') +
            '\n})(local);\n';
    },

    // Get common/storage.js
    getStorage: () => {
        return '(function (local) {\n' +
            fs.readFileSync(resolvedCodeDir + '/common/storage.js', 'utf8')
                .replace('module.exports = Storage;', 'local.Storage = Storage;')
                .replace('require(\'./prefix\')', 'local.getPrefix') +
            '\n})(local);\n';
    },

    // Get common/svg.js
    getSVG: () => {
        return '(function (local) {\n' +
            fs.readFileSync(resolvedCodeDir + '/common/svg.js', 'utf8')
                .replace('module.exports = SVG;', 'local.SVG = SVG;')
                .replace('var config = Object.create(null);', 'var config = local.config;')
                .replace('SVG._config = config;', '')
                .replace('require(\'./storage\')', 'local.Storage') +
            '\n})(local);\n';
    },

    // Fake events.js
    fakeEvents: () => {
        return 'local.event = function(name, params) { if (local[name] !== void 0) local[name](params); };'
    },

    // Fake init.js
    fakeInit: () => {
        let content = fs.readFileSync(resolvedCodeDir + '/browser/init.js', 'utf8');

        content = TestHelper.replace(
            content,
            'if (document.readyState === \'complete\' || (document.readyState !== \'loading\' && !document.documentElement.doScroll)) {',
            'if (true) {',
            'Cannot find required code in init.js'
        );

        return content;
    }
};

/**
 * Find all files, parse them
 */
glob(resolvedSourceDir + '/**/*.js', {
    dot: true
}, (err, files) => {
    files.forEach(file => {
        if (file.slice(-9) === '.build.js') {
            let code = require(file)(Helper, resolvedCodeDir, file.replace('.build.', '.test.'), TestHelper),
                targetFile = resolvedTargetDir + file.slice(resolvedSourceDir.length).replace('.build.', '.'),
                test = targetDir + targetFile.slice(resolvedTargetDir.length);

            if (!code.length) {
                console.log('Ignoring compiled test:', test);
                return;
            }

            Helper.mkdir(path.dirname(targetFile));
            fs.writeFileSync(targetFile, code, 'utf8');

            console.log('Compiled test:', test);
            tests.push(test);
            return;
        }

        if (file.slice(-11) === '.browser.js') {
            let test = sourceDir + file.slice(resolvedSourceDir.length);
            console.log('Browser specific test:', test);
            tests.push(test);
            return;
        }
    });

    let time = Date.now();
    fs.writeFileSync(resolvedTargetDir + '/tests.js',
        '/* generated by build tool: node build/tests */\n' +
        tests.map(file => 'document.write(\'<script src="' + file + '?t=' + time + '"></script>\');').join('\n')
    );
    console.log('Saved list of tests to', resolvedTargetDir + '/tests.js');
    console.log('Open tests.html in browser to run tests.');
});
