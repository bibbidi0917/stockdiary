var transactions = {
    init: function(){
        var _this = this;
        $('#btn-search-transaction').on('click', function () {
            _this.searchTransaction();
            _this.searchPrice();
        });
    },

    searchTransaction : function () {
        var html = "";
        var data = $('#searchStockName').val();

        $.ajax({
            type: 'GET',
            url: '/api/transactions?q='+data,
            dataType:'json',
            contentType:'application/json; charset=utf-8'
        }).done(function(data){
            $.each(data, function(key,value){
                html += "<tr>" +
                    "<td>"+ value.date + "</td>" +
                    "<td>"+ value.type+"</td>" +
                    "<td>"+ value.stockName+"</td>" +
                    "<td>"+ value.sum+"</td>" +
                    "<td>"+ value.count+"</td>" +
                    "</tr>";
            })
            html += "</tbody></table>";
            $("#displayT").empty();
            $("#displayT").append(html);
            //alert(data);
            //location.reload();
        }).fail(function (request, status, error) {
            //alert("request: "+request+" status: "+status +" error: "+error);
        });
    },

    searchPrice : function () {
        var html = "<div class=\"card card-light-blue\">\n" +
            "                                    <div class=\"card-body\">";
        var data = $('#searchStockName').val();
        var name = data;
        $.ajax({
            type: 'GET',
            url: '/koscom/price?mc=kospi&ic='+data,
            dataType:'text',
            contentType:'application/json; charset=utf-8'
        }).done(function(data){
            html += "<p class=\"mb-4\">현재 주가는</p>" +
                "<p class=\"fs-30 mb-2\">" + data + "원</p>";
            html += "</div></div>";
            $("#displayPrice").empty();
            $("#displayPrice").append(html);
            //alert(data);
            //location.reload();
        }).fail(function (request, status, error) {
            alert("request: "+request+" status: "+status +" error: "+error);
        });
    }

};
transactions.init();