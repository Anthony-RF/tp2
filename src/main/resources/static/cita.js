// Función para eliminar una cita
function deleteCita(fecha, cedulaPaciente, idMedico) {
    if (confirm('¿Estás seguro de que deseas eliminar esta cita?')) {
        $.ajax({
            url: '/citas/delete/' + fecha + '/' + cedulaPaciente + '/' + idMedico,
            type: 'DELETE',
            success: function(response) {
                // Actualizar la vista o realizar otras acciones necesarias
                location.reload(); // Recargar la página
            },
            error: function(error) {
                // Manejar errores
            }
        });
    }
}