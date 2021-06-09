import spark.Request
import spark.Response
import spark.Spark.*
import java.io.File

fun main(){
    staticFiles.location("/public")
    get("/"){req, res -> "test"}
    get("/map"){req, res -> getMap(req,res)}
    post("/maps"){req, res -> postMap(req, res)}

}

fun postMap(req: Request, res: Response){
    print(req.body())
    File("src/main/resources/maps/map.json").writeText(req.body())
}
fun getMap(req: Request, res: Response): String{

//    File("src/main/resources/maps/map.json").writeText(req.body())
return File("src/main/resources/maps/map.json").readText()
}