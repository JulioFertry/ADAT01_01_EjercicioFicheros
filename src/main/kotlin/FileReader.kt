import java.io.BufferedReader
import java.nio.file.Files
import java.nio.file.Path

class FileReader {

    /** Transforma un fichero de tipo CSV a un mapa
     *
     * @param csvPath Ruta del fichero CSV
     *
     * @return Mapa con la información del fichero
     */
    fun getMarketInfo(csvPath: Path): Map<String, List<Float>> {
        if (Files.notExists(csvPath)) {
            throw IllegalArgumentException(" - No existe el archivo")
        }

        val marketMappedInfo = mutableMapOf<String, List<Float>>()
        val br: BufferedReader = Files.newBufferedReader(csvPath)

        var isFirstLine = true
        br.use { reader ->
            reader.forEachLine { line ->
            if (isFirstLine) {
                isFirstLine = false
            } else {
                val values = line.split(";")
                val companyName = values[0]

                val onlyNumericValues = values.drop(1)
                val companyData = onlyNumericValues.map {
                    it
                        .replace(".", "")
                        .replace(",", ".")
                        .toFloat()
                }

                marketMappedInfo[companyName] = companyData
            }
        } }

        return marketMappedInfo
    }

}