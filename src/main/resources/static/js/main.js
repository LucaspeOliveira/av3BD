document.addEventListener('DOMContentLoaded', function() {
  // Inicializa selects (Materialize)
  var elems = document.querySelectorAll('select');
  if (elems && M && M.FormSelect) {
    M.FormSelect.init(elems);
  }

  // Inicializa textareas auto-resize
  var textareas = document.querySelectorAll('.materialize-textarea');
  if (textareas) {
    textareas.forEach(function(t){
      M.textareaAutoResize(t);
    });
  }

  // Tooltips (se houver)
  var tooltipEls = document.querySelectorAll('.tooltipped');
  if (tooltipEls && M && M.Tooltip) {
    M.Tooltip.init(tooltipEls);
  }
});
