function createNewMeeting() {
    // form validation
    var valid = true;
    var errs = document.getElementsByClassName("validation-err");
    var i;
    for (i = 0; i < errs.length; i++) {
        errs[i].classList.add("hidden");
    }
    var eventName = document.getElementById("eventName").value;
    if (eventName == "") {
        errs[0].classList.remove("hidden");
        valid = false;
    }
    var checked = document.querySelector("input[type=checkbox]:checked");
    if (checked == null || checked.length <= 0 || checked.length > 7) {
        errs[1].classList.remove("hidden");
        valid = false;
    }
    var start = Number(document.getElementById("startTime").value);
    var end = Number(document.getElementById("endTime").value);
    if (isNaN(start) || !Number.isInteger(start) || start < 0 || start > 24 ) {
        errs[2].classList.remove("hidden");
        valid = false;
    }
    if (isNaN(end) || !Number.isInteger(end) || end < 0 || end > 24 || end <= start ) {
        errs[3].classList.remove("hidden");
        valid = false;
    }

    if (valid) {
        document.getElementById("newMeeting").submit();
    }
}