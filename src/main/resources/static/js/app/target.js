var target = {
    init: function(){
        var _this = this;
        $('#btn-finalTarget-create').on('click', function(){
            _this.loadFinalTargetPopup();
        })
    },
    loadFinalTargetPopup: function (){
        var popupWidth = 600;
        var popupHeight = 800;

        var popupX = (window.screen.width / 2) - (popupWidth / 2);
// 만들 팝업창 width 크기의 1/2 만큼 보정값으로 빼주었음

        var popupY= (window.screen.height / 2) - (popupHeight / 2);
// 만들 팝업창 height 크기의 1/2 만큼 보정값으로 빼주었음
        window.open('/target/finalTargetCreate', '', 'status=no, height=' + popupHeight  + ', width=' + popupWidth  + ', left='+ popupX + ', top='+ popupY);
    }
}
target.init();