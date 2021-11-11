var index = {
    init: function() {
        var _this = this;
        $('#btn-search-news').on('click', function () {
            _this.searchNews();
        });
    },

    searchNews: function (){
        var html = "<table className=\"table table-striped\"> <tbody>"
        var data = $('#searchWord').val();

        $.ajax({
            type: 'GET',
            url: '/api/search/news?q='+data,
            dataType:'json',
            contentType:'application/json; charset=utf-8'
        }).done(function(data){
                $.each(data, function(key,value){
                    html += "<tr><td><a href=\""+value.link+"\" target='_blank'>"+value.title+"</a></td></tr>";
                })
            html += "</tbody></table>";
            $("#display").empty();
            $("#display").append(html);
        });
    }
};
index.init();