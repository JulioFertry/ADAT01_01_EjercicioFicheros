import java.nio.file.Path

fun main() {

    // Instancia un lector de archivos
    val reader = FileReader()

    // Crea las rutas necesarias
    val root = Path.of("src")
    val csvFilePath = root.resolve("main").resolve("resources").resolve("cotizacion.csv")

    // Lee el fichero, lo transforma a mapa
    try {
        val info = reader.getMarketInfo(csvFilePath)
        info.forEach{ println(it) }
    } catch (e: Exception) {
        println("***ERROR*** ${e.message}")
    }

}