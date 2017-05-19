module.exports = function(grunt) {

	require('load-grunt-tasks')(grunt);

	var config = {
		app: 'app',
		tmp: '.tmp',
		dist: '../backend/public',
		jades: [
			'index.jade',

			'sections/inicial.jade',
			'sections/usuarios.jade',
			'sections/cargos.jade',
			'sections/perfis.jade',
			'sections/adicionarUsuario.jade',
			'sections/historicoUsuarios.jade',

		]
	};
		
	grunt.initConfig({

		config: config,

		watch: {
			
			grunt: {
				files: [
					'Gruntfile.js'
				],
				tasks: ['default']
			},
			less: {
				files: [
					'<%= config.app %>/styles/**/*.less'
				],
				tasks: ['less']
			},
			jade: {
				files: [
					'<%= config.app %>/views/**/*.jade'
				],
				tasks: ['jade:all'],
				options: {
					spawn: false,
				},
			},
			scripts: {
				files: [
					'<%= config.app %>/**/*.js'
				],
				tasks: ['jshint', 'copy:scripts', 'copy:config'],
				options: {
					spawn: false,
				},
			},
			images: {
				files: [
					'<%= config.app %>/images/**/*.{png,jpg,jpeg,gif,webp,svg}'
				],
				tasks: ['copy:images']
			}

		},

		jade: {
			all: {
				options: {
					pretty: true,
					basedir: '<%= config.app %>/views',
				},
				files: [{
					expand: true,
					dest: '<%= config.dist %>/views',
					ext: '.html',
					cwd: '<%= config.app %>/views',
					src: '<%= config.jades %>'
				}]
			},
			
			dist: {
				options: {
					pretty: true
				},
				files: {
					'<%= config.dist %>/views/index.html': '<%= config.app %>/views/index.jade.tmp'
				}
			}

		},

        less: {

            dev: {
                files: [
                    {
                        expand: true,
                        cwd: '<%= config.app %>',
                        src: ['styles/**/*.less', '!styles/bootstrap/**/*.less'],
                        dest: '<%= config.dist %>',
                        ext: '.css'
                    }
                    // {
                    //     src: '<%= config.app %>/styles/bootstrap/bootstrap.less',
                    //     dest: '<%= config.dist %>/styles/bootstrap.css'
                    // }
                ]
            }

        },

		autoprefixer: {
			options: {
				browsers: ['last 2 versions','ie 10'],
				cascade: true,
				remove: true
			}
		},

		copy: {

			scripts: {
				files: [{
					expand: true,
					flatten: false,
					cwd: '<%= config.app %>/scripts',
					src: ['**/*.js', '!config*.js'],
					dest: '<%= config.dist %>/scripts'
				}]
			},

			// Somente scripts minificados
			depsScriptsMin: {
				files: [
					{
						expand: true,
						flatten: true,
						cwd: 'bower_components',
						src: [
							'jquery/dist/jquery.min.js',
							'jquery/dist/jquery.min.map',
							'angular/angular.min.js',
							'angular/angular.min.js.map',
							'underscore/underscore-min.js',
							'underscore/underscore-min.map',
							'bootstrap/dist/js/bootstrap.min.js',
							'angular-bootstrap/ui-bootstrap.min.js',
							'angular-bootstrap/ui-bootstrap-tpls.min.js',
							'angular-route/angular-route.min.js',
							'angular-route/angular-route.min.js.map',
							'angular-animate/angular-animate.min.js'
						],
						dest: '<%= config.dist %>/scripts'
					},

					{
						expand: true,
						flatten: true,
						cwd: 'bower_components',
						src: [
							'pickadate/lib/compressed/picker.js',
							'pickadate/lib/compressed/picker.date.js',
							'pickadate/lib/compressed/picker.time.js',
							'pickadate/lib//translations/pt_BR.js'
						],
						dest: '<%= config.dist %>/scripts',
						rename: function(dest, src) {
							return dest + "/" + src.replace(/\.js$/, ".min.js");
						}
					}
				]
			},

			// Somente scripts não minificados que possuir versão minificada
			depsScriptsSrc: {
				files: [
					{
						expand: true,
						flatten: true,
						cwd: 'bower_components',
						src: [
							'jquery/dist/jquery.js',
							'angular/angular.js',
							'angular-animate/angular-animate.js',
							'bootstrap/dist/js/bootstrap.js',
							'angular-bootstrap/ui-bootstrap.js',
							'angular-bootstrap/ui-bootstrap-tpls.js',
							'angular-route/angular-route.js'
						],
						dest: '<%= config.dist %>/scripts',
						rename: function(dest, src) {
							return dest + "/" + src.replace(/\.js$/, ".min.js");
						}
					},

					{
						expand: true,
						flatten: true,
						cwd: 'bower_components',
						src: [
							'underscore/underscore.js'
						],
						dest: '<%= config.dist %>/scripts',
						rename: function(dest, src) {
							return dest + "/" + src.replace(/\.js$/, "-min.js");
						}
					}

				]

			},

			deps: {
				files: [

					// Scripts que não possuem versão minificada
					{
						expand: true,
						flatten: true,
						cwd: 'bower_components',
						src: [

						],
						dest: '<%= config.dist %>/scripts'
					},

					{
						expand: true,
						flatten: true,
						cwd: 'bower_components/',
						src: [
							'jquery-ui/themes/base/minified/jquery-ui.min.css'
						],
						dest: '<%= config.dist %>/styles'
					},

					{
						expand: true,
						flatten: true,
						cwd: 'bower_components/dropzone/downloads/images',
						src: ['spritemap.png', 'spritemap@2x.png'],
						dest: '<%= config.dist %>/images'
					}

				]

			},

			images: {
				files: [
					{
						expand: true,
						flatten: false,
						cwd: 'bower_components/select2/',
						src: ['**/*.{png,jpg,jpeg,gif,webp,svg}'],
						dest: '<%= config.dist %>/styles'
					},

					{
						expand: true,
						flatten: false,
						cwd: '<%= config.app %>/images/',
						src: ['**/*.{png,jpg,jpeg,gif,webp,svg}'],
						dest: '<%= config.dist %>/images'
					},

					{
						expand: true,
						flatten: true,
						cwd: '../car-ui-components/src/img',
						src: ['**/*.png','**/*.jpg', '**/*.gif', '**/*.ico'],
						dest: '<%= config.dist %>/images/car-ui'
					}

				]
			},

			fonts: {
				files: [
					{
						expand: true,
						flatten: false,
						cwd: '<%= config.app %>/fonts/',
						src: ['**/*'],
						dest: '<%= config.dist %>/fonts'
					},
					{
						expand: true,
						cwd: 'bower_components',
						src: ['**/*.{eot,svg,ttf,woff,woff2}'],
						flatten: true,
						dest: '<%= config.dist %>/fonts'
					}
				]
			},

			manual: {
				files: [
					{
						expand: true,
						flatten: false,
						cwd: '<%= config.app %>/manual/',
						src: ['**/*', '!**/*.adoc', '!**/*.pdfmarks'],
						dest: '<%= config.dist %>/manual'
					}
				]
			},

			config: {
				files: [
					{
						expand: true,
						flatten: true,
						cwd: '<%= config.app %>/scripts',
						src: ['appConfig.js'],
						dest: '<%= config.dist %>/scripts'
					}
				]
			},

			configBuild: {
				files: [
					{
						expand: true,
						flatten: true,
						cwd: '<%= config.app %>/scripts',
						src: ['config.js'],
						dest: '<%= config.app %>/scripts',
						rename: function(dest) {
							return dest + '/appConfig.js';
						}
					}
				]
			},

			configTest: {
				files: [
					{
						expand: true,
						flatten: true,
						cwd: '<%= config.app %>/scripts',
						src: ['config.test.js'],
						dest: '<%= config.app %>/scripts',
						rename: function(dest) {
							return dest + '/appConfig.js';
						}
					}
				]
			},

			configPresentation: {
				files: [
					{
						expand: true,
						flatten: true,
						cwd: '<%= config.app %>/scripts',
						src: ['config.presentation.js'],
						dest: '<%= config.app %>/scripts',
						rename: function(dest) {
							return dest + '/appConfig.js';
						}
					}
				]
			},

			configHomologation: {
				files: [
					{
						expand: true,
						flatten: true,
						cwd: '<%= config.app %>/scripts',
						src: ['config.homologation.js'],
						dest: '<%= config.app %>/scripts',
						rename: function(dest) {
							return dest + '/appConfig.js';
						}
					}
				]
			},

			configProduction: {
				files: [
					{
						expand: true,
						flatten: true,
						cwd: '<%= config.app %>/scripts',
						src: ['config.production.js'],
						dest: '<%= config.app %>/scripts',
						rename: function(dest) {
							return dest + '/appConfig.js';
						}
					}
				]
			}

		},

		clean: {

			options: { force: true },

			all: {
				files: [{
					dot: true,
					src: [
						'<%= config.tmp %>/*',
						'<%= config.dist %>/*',
						'!<%= config.dist %>/.git*'
					]
				}]
			},

			config: {
				src: [
					'<%= config.app %>/scripts/appConfig.js'
				]
			},

			index: {
				src: [
					'<%= config.app %>/views/index.jade.tmp'
				]
			}

		},

		jadeUsemin: {

			scripts: {
				options: {
					tasks: {
						js: ['ngmin', 'uglify'],
						css: ['concat', 'cssmin']
					},
					prefix: '<%= config.app %>',
					targetPrefix: '<%= config.dist %>'
				},
				files: [{
					src: '<%= config.app %>/views/index.jade',
					dest: '<%= config.app %>/views/index.jade.tmp'
				}]
			}

		},
		
		jshint: {
			options: {
				jshintrc: '.jshintrc'
			},
			all: [
				'Gruntfile.js',
				'<%= config.app %>/scripts/**/*.js'
			]
		},

		bower: {
			install: {
				options: {
					install: true,
					verbose: true,
					copy: false
				}
			}
		}

	});

	var JadeInheritance = require('jade-inheritance');
	var changedJades = [];

	var onJadeChange = grunt.util._.debounce(function() {

		var options = grunt.config('jade.all.options');
		var dependantFiles = [];

		changedJades.forEach(function(filename) {

			var directory = options.basedir;
			var inheritance = new JadeInheritance(filename, directory, options);

			dependantFiles = dependantFiles.concat(inheritance.files);
		});

		var compileFiles = [];
		config.jades.forEach(function(file){

			if(dependantFiles.indexOf(file) !== -1){
				compileFiles.push(file);
			}

		});

		var taskConfig = grunt.config('jade.all.files')[0];

		taskConfig.src = compileFiles;
		grunt.config('jade.all.files', [taskConfig]);

		changedJades = [];

	}, 200);

	var changedScripts = [];

	var onScriptChange = grunt.util._.debounce(function() {

		grunt.config('jshint.all', changedScripts);

		var taskConfig = grunt.config('copy.scripts.files')[0];

		var copyList = [];

		for (var i = 0; i < changedScripts.length; i++) {
			copyList.push(changedScripts[i].replace(taskConfig.cwd + '/', ''));
		}

		taskConfig.src = copyList;

		grunt.config('copy.scripts.files', [taskConfig]);

		changedScripts = [];

	}, 200);

	grunt.event.on('watch', function(action, filepath) {

		if(filepath.indexOf(".jade") !== -1) {
			changedJades.push(filepath);
			onJadeChange();
		} else if(filepath.indexOf(".js") !== -1) {
			changedScripts.push(filepath);
			onScriptChange();
		}

	});

	grunt.registerTask('default', [
		'bower:install',
		'jshint',
		'clean:all',
		'less',
		'autoprefixer',
		'jade:all',
		'copy:scripts',
		'copy:images',
		'copy:fonts',
		'copy:depsScriptsSrc',
		'copy:deps',
		'copy:configBuild',
		'copy:config',
		'clean:config',
		'copy:manual',
		'watch'
	]);

	grunt.registerTask('debug', function (target) {

		grunt.task.run([
			'bower:install',
			'jshint',
			'clean:all',
			'copy:scripts',
			'copy:configBuild'
		]);

		if (target === 'test') {

			grunt.task.run(['copy:configTest']);

		} else if (target === 'presentation') {

			grunt.task.run(['copy:configPresentation']);

		} else if (target === 'homologation') {

			grunt.task.run(['copy:configHomologation']);

		}

		grunt.task.run([
			'copy:config',
			'clean:config',
			'less',
			'autoprefixer',
			'jade:all',
			'copy:images',
			'copy:fonts',
			'copy:depsScriptsSrc',
			'copy:deps',
			'copy:manual'
		]);

	});

	grunt.registerTask('build', function (target) {

		grunt.task.run([
			'bower:install',
			'jshint',
			'clean:all',
			'copy:configBuild'
		]);

		if (target === 'test') {

			grunt.task.run(['copy:configTest']);

		} else if (target === 'presentation') {

			grunt.task.run(['copy:configPresentation']);

		} else if (target === 'homologation') {

			grunt.task.run(['copy:configHomologation']);

		} else if (target === 'production') {

			grunt.task.run(['copy:configProduction']);

		}

		grunt.task.run([
			'jadeUsemin',
			'less',
			'autoprefixer',
			'jade:all',
			'jade:dist',
			'copy:deps',
			'copy:depsScriptsMin',
			'copy:images',
			'copy:fonts',
			'copy:manual',
			'clean:config',
			'clean:index'
		]);
		
	});

};
