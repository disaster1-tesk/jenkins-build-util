window.onload=function(){
    var isCheckAllt = false;
    var testbtn = document.getElementById("testselectall");
    var rebtn = document.getElementById("releaseselectall");
    testbtn.onclick=function(){
        $("input[class='testcheck']").each(function() {
				this.checked = !isCheckAllt;
			});
		    isCheckAllt = !isCheckAllt;
        // alert('这就是点击事件~');
    }
    var isCheckAll = false;
    rebtn.onclick=function(){
        $("input[class='recheck']").each(function() {
				this.checked = !isCheckAll;
			});
		    isCheckAll = !isCheckAll;
        // alert('这就是点击事件~');
    }
}
