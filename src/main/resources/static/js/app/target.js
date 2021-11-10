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
    },
    loadFinalTargetPopup: function (){
        var popupWidth = 600;
        var popupHeight = 800;

        var popupX = (window.screen.width / 2) - (popupWidth / 2);
        var popupY= (window.screen.height / 2) - (popupHeight / 2);

        window.open('/target/finalTargetCreate', '', 'status=no, height=' + popupHeight  + ', width=' + popupWidth  + ', left='+ popupX + ', top='+ popupY);
    },
    saveFinalTarget: function (){
        //form 데이터 말아서 최종 목표 저장하는 url로 ajax 보내기
        alert("target.js 의 saveFinalTarget 들어옴!");
    }
}
target.init();