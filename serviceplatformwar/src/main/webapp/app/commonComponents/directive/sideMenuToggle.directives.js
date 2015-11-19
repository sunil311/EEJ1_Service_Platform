'use strict';
app.directive('expandCollapseLeftLink', function() {
        return {
            restrict: 'AC',
            link: function(scope, element, attrs) {
                
                element.bind('click', function(event) {

                    scope.grid.jqxGrid('beginupdate');
                   /*$('.left-column-section').toggle();*/
                    $("#wrapper").toggleClass("toggled");
                    $('.udm-left-panel').toggle();

                    $('.expand-collapse-left-link span').toggleClass('udm-icon-close');
                    $('.expand-collapse-left-link span').toggleClass('udm-icon-open');
                    $('.udm-lnk-expand-configuration span').toggleClass('udm-icon-close');
                    $('.udm-lnk-expand-configuration span').toggleClass('udm-icon-open');
                   /* $('.middle-column-section').toggleClass('col-xs-9');
                    $('.middle-column-section').toggleClass('col-xs-12');*/


                    $('.udm-right-panel').toggleClass('udm-full-width');


                    scope.grid.jqxGrid('endupdate');

                    return false;
                });
            }
        };

    });
