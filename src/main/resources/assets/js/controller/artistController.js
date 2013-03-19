define(['jquery', 'underscore'], function($, _, when) {

    var artistsElement;
    var controller = function() {

        var fetchArtists = function() {
            return $.ajax({
                url: '/dudes',
                dataType: 'json'
            });
        };

        var updateGUI = function() {
            fetchArtists().then(function(response) {
                _.each(response, function(item) {
                    // TODO: Add info like you want...
                    $(artistsElement).append(item);
                });
            });
        };
        var post = function(data) {
            $.ajax({
                url: '/dudes',
                dataType: 'json',
                data: data,
                type: 'POST'
            }).then(function(response) {
                updateGUI();
            });
        };

        function bindPostForm(form) {
            $(form).submit(function(e) {
                e.preventDefault();
                var data = {};
                _.each($(this).find('input'), function(inputElement) {
                    data[inputElement.name] = $(inputElement).val();
                });
                post(data);
            });
        }
        return {
            init: function(elem) {
                controller.elem = $(elem);
                return this;
            },
            render: function() {
                artistsElement = $(controller.elem).find('#artists');
                bindPostForm($(controller.elem).find('#postArtistForm'));
                updateGUI();
            }
        };
    };


    // init function
    return function(elem, options) {
        return Object.create(controller()).init(elem, options);
    };

});