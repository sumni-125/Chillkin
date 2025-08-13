/**
 * 
 */

setInterval(function() {
	console.log("session-check.js 로드됨1");
    $.ajax({
        url: '/Chillkin/session-check',
        method: 'GET',
        dataType: 'json',
        success: function(data) {
            console.log(data);
            if (data.valid) {
				console.log("session-check.js 로드됨2");
                if (confirm("정해진 세션이 만료됩니다. 시간을 연장하시겠습니까?")) {
                    $.ajax({
                        url: '/Chillkin/keep-alive',
                        method: 'GET',
                        dataType: 'json',
                        success: function(result) {
                            alert(result.message);
                        },
                        error: function(xhr, status, error) {
                            console.error("세션 연장 실패:", error);
                            alert("세션 연장에 실패했습니다.");
                            window.location.href = "/Chillkin/login";
                        }
                    });
                } else {
                    window.location.href = "/Chillkin/login";
                }
            }
        },
        error: function(xhr, status, error) {
            console.error("세션 체크 실패:", error);
        }
    });
}, 1800000);