function quesValid(form,tag,min,max)
{
    var x=document.forms[form][tag].value;
    if (isNaN(x)||!x) {
        alert("יש להכניס מספר בין 1 ל-300");
        return false;
    }
    else {
        if(x>max || x<min){
            alert("יש להכניס מספר בין 1 ל-300");
            return false;
        }
    }
    return true;
}