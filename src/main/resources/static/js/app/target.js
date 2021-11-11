var target = {
    init: function(){
        var _this = this;
        //최종 목표 생성 팝업 호출
        $('#btn-finalTarget-create').on('click', function(){
            _this.loadFinalTargetPopup();
        });
        
        //최종 목표 저장
        $('#btn-finalTarget-save').on('click', function(){
            _this.saveFinalTarget();
        });

        //수행 목표 생성 팝업 호출
        $('#btn-PerformanceTarget-create').on('click', function(){
            _this.loadPerformanceTargetPopup();
        });

        //수행 목표 저장
        $('#btn-performanceTarget-save').on('click', function(){
            _this.savePerformanceTarget();
        });
    },
    loadFinalTargetPopup: function (){
        var popupWidth = 600;
        var popupHeight = 800;

        var popupX = (window.screen.width / 2) - (popupWidth / 2);
        var popupY= (window.screen.height / 2) - (popupHeight / 2);

        window.open('/target/finalTargetCreate', '', 'status=no, height=' + popupHeight  + ', width=' + popupWidth  + ', left='+ popupX + ', top='+ popupY);
    },
    saveFinalTarget: function (){
        var data ={
            title:$('#finalTargetName').val(),
            startDate : $('#finalTargetStartDate').val(),
            endDate : $('#finalTargetEndDate').val()
        };

        $.ajax({
            type: 'POST',
            url:'/api/goal/final',
            dataType: 'json',
            contentType:'application/json; charset=utf-8',
            data: JSON.stringify(data)
        })

        alert('최종 목표가 저장되었습니다.');

        opener.document.location.reload();
        self.close();
    },
    loadPerformanceTargetPopup: function (){
        var popupWidth = 600;
        var popupHeight = 800;

        var popupX = (window.screen.width / 2) - (popupWidth / 2);
        var popupY= (window.screen.height / 2) - (popupHeight / 2);

        url = '/target/performanceTargetcreate/'+$('#finalSeq').val();

        window.open(url, '', 'status=no, height=' + popupHeight  + ', width=' + popupWidth  + ', left='+ popupX + ', top='+ popupY);
    },
    savePerformanceTarget: function (){
        var data={
            title:$('#performanceTargetName').val(),
            startDate : $('#performanceTargetStartDate').val(),
            endDate : $('#performanceTargetEndDate').val(),
            tag1: $('#performanceTargetTag1').val(),
            tag2: $('#performanceTargetTag2').val(),
            tag3: $('#performanceTargetTag3').val()
        };
        var url = '/api/goal/'+$('#finalSeq').val()+'/perf'

        $.ajax({
            type: 'POST',
            url:url,
            dataType: 'json',
            contentType:'application/json; charset=utf-8',
            data: JSON.stringify(data)
        })

        alert('수행 목표가 저장되었습니다.');

        opener.document.location.reload();
        self.close();
    }
}
target.init();