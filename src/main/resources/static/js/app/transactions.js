var transactions = {
    init: function(){
        var _this = this;
        $('#btn-search-transaction').on('click', function () {
            var stockName = $('#searchStockName').val();
            _this.searchTransaction(stockName);
            _this.searchPrice(stockName);
        });
    },

    searchTransaction : function (stockName) {
        var html = "";
        //var stockName = $('#searchStockName').val();

        $.ajax({
            type: 'GET',
            url: '/api/transactions?q='+stockName,
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

    searchPrice : function (stockName) {
        var html = "<div class=\"card card-light-blue\">\n" +
            "                                    <div class=\"card-body\">";
        //var data = $('#searchStockName').val();
        var name = stockName;
        $.ajax({
            type: 'GET',
            url: '/koscom/price?mc=kospi&ic='+stockName,
            dataType:'text',
            contentType:'application/json; charset=utf-8'
        }).done(function(data){
            html += "<h3>" + name + "</h3>" + "<p class=\"mb-4\">현재 주가는</p>" +
                "<p class=\"fs-30 mb-2\">" + data + "원</p>";
            html += "</div></div>";
            $("#displayPrice").empty();
            $("#displayPrice").append(html);
            //alert(data);
            //location.reload();
        }).fail(function (request, status, error) {
            //alert("request: "+request+" status: "+status +" error: "+error);
        });
    },

    searchByTag : function (stockName) {
        this.searchTransaction(stockName);
        this.searchPrice(stockName);
    }

};
transactions.init();