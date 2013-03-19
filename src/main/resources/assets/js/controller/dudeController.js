define(['jquery', 'underscore'], function($, _, when) {

    var dudeElement;
    var controller = function() {

        var fetchDudes = function() {
            return $.ajax({
                url: '/rest/dudes',
                dataType: 'json'
            });
        };

        var updateGUI = function() {
            $(dudeElement).empty();
            fetchDudes().then(function(response) {
                _.each(response, function(item) {
                    // TODO: Add info like you want...
                    $(dudeElement).append(item);
                });
            });
        };
        var post = function(data) {
            $.ajax({
                url: '/rest/dudes',
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
                dudeElement = $(controller.elem).find('#dudes');
                bindPostForm($(controller.elem).find('#postDudeForm'));
                updateGUI();
            }
        };
    };


    // init function
    return function(elem, options) {
        return Object.create(controller()).init(elem, options);
    };

});