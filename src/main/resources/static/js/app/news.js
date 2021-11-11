var news = {
    init: function() {
        var _this = this;
    },
    searchByTag: function (stockName) {
        var html = "";
        $.ajax({
            type: 'GET',
            url: '/api/search/news?q='+stockName,
            dataType: 'json',
            contentType: 'application/json; charset=utf-8'
        }).done(function(data) {
            $.each(data, function(key,value){
                html += "<tr><td><a href=\""+value.link+"\" target='_blank'>"+value.title+"</a></td></tr>";
            })
            html += "</tbody></table>";
            $("#display").empty();
            $("#display").append(html);
        })
    }
};
news.init();