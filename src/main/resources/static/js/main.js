document.addEventListener('DOMContentLoaded', function() {

  var elems = document.querySelectorAll('select');
  if (elems && M && M.FormSelect) {
    M.FormSelect.init(elems);
  }


  var textareas = document.querySelectorAll('.materialize-textarea');
  if (textareas) {
    textareas.forEach(function(t){
      M.textareaAutoResize(t);
    });
  }


  var tooltipEls = document.querySelectorAll('.tooltipped');
  if (tooltipEls && M && M.Tooltip) {
    M.Tooltip.init(tooltipEls);
  }
});
