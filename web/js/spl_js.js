function spl_to_pdf(){
    var dokument = new jsPDF();
    var ignoredElements = { 
        '#ignore': function (element, renderer) {
            return true;
        },
        '#ignore_2': function (element, renderer) {
            return true;
        }
    };
    var izvor = window.document.getElementsByTagName("body")[0];
    dokument.fromHTML(
        izvor,
        15,
        15,
        {
            'width': 200,'elementHandlers': ignoredElements
        }
    );
    dokument.save('document.pdf');
}
