import java.nio.file.Files
import java.nio.file.Path
import kotlin.io.path.notExists

fun main() {

    // Instancia un lector de archivos y un escritor de archivos
    val reader = FileReader()
    val writer = FileWriter()


    // Crea las rutas necesarias
    val root = Path.of("src")
    val csvFilePath = root.resolve("main").resolve("resources").resolve("cotizacion.csv")
    val resultPath =
        root.resolve("main").resolve("resources").resolve("result").resolve("resultado.csv")


    // Lee el fichero, lo transforma a mapa y crea un fichero con los cálculos
    try {
        val info = reader.getMarketInfo(csvFilePath)

        if (resultPath.notExists()) {
            Files.createDirectories(resultPath.parent)
            Files.createFile(resultPath)
        }
        writer.writeMarketCalculations(info, resultPath)
    } catch (e: Exception) {
        println("***ERROR*** ${e.message}")
    }

}