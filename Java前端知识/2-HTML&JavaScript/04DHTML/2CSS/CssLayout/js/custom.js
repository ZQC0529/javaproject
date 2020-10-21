/// <reference path="../lib/jquery-1.2.6.min.js" />
/// <reference path="../lib/styleswitch.js" />
/// <reference path="../lib/equalcolumns.js" />

$(document).ready(function() {
    // $("#SelectColumnsFixed").hide();
    $(".[name='layout']").click(function() {
        if ($(this).val() == "fixed") {
            $("#SelectColumnsFixed").show();
            $("#SelectColumnsLiquid").hide();
                  $("#pic1").show();
                $("#pic2").hide();
        
            selectStylehandler("fixed/2_1.css");

        }
        else {
            $("#SelectColumnsFixed").hide();
            $("#SelectColumnsLiquid").show();
                  $("#pic2").show();
                $("#pic1").hide();
          
            selectStylehandler("liquid/2_1.css");

        }
    });
    $(".[name='layout']")[0].click();

    $("#SelectColumnsFixed").change(function() {
        selectStylehandler($(this).val());
    });
    $("#SelectColumnsLiquid").change(function() {
        selectStylehandler($(this).val());
    });

    $("#showpic").click(function() {
        if ($(this).attr("checked")) {
            $("#show").show();
        }
        else {
            $("#show").hide();
        }

        ddequalcolumns.resetHeights();
    });

});

function selectStylehandler(style) {
    if (style != "") {
        //$("#maincontainer").fadeOut(200);
        switchStylestyle(style);
        //     $("#maincontainer").fadeIn(500);
        ddequalcolumns.resetHeights();
    }
}