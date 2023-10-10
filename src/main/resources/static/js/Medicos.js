// Call the dataTables jQuery plugin
$(document).ready(function() {
  cargarMedicos();
  $('#TablaMedicos').DataTable();
});

async function cargarMedicos() {

  const request = await fetch('Medicos', {
    method: 'GET',
    headers: {'Accept': 'application/json', 'Content-Type': 'application/json'}
  });
  const medicos = await request.json();

  console.log(medicos);

  let listadoHtml = "";

  for (let medico of medicos) {

    let medicoHtml = '' +
        '<tr>' +
        '<td>' + medico.cedula + '</td>' +
        '<td>' + medico.nombre + '</td>' +
        '<td>' + medico.apellido + '</td>' +
        '<td>' + medico.correo + '</td>' +
        '<td>' + medico.identificador + '</td>' +
        '<td>' + medico.especialidad + '</td>' +
        '<td><a href="#" class="btn btn-info btn-circle">\n<i class="fas fa-info-circle"></i>\n</a></td><td><a href="#" class="btn btn-danger btn-circle">\n<i class="fas fa-trash"></i>\n</a></td></tr>';

    listadoHtml += medicoHtml;

  }

  return document.querySelector('#medicos tbody').outerHTML = listadoHtml;

}