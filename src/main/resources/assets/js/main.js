requirejs.config({
    baseUrl: 'js',
    paths: {
        jquery: 'libs/jquery/jquery-1.9.0',
        underscore: 'libs/underscore/underscore-1.2.3',
        when: 'libs/when/when-1.7.1'
    },
    shim: {
        'app': {
            deps: ['jquery', 'underscore', 'when'],
            exports: 'app'
        }
    }
});


requirejs(['app'], function(App) {
    var app = new App("#main");
    $(document).ready(function() {
        app.run();
    });
});