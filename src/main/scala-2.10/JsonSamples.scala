import scala.io.Source
import scala.reflect.io.File
import org.json4s._
import org.json4s.jackson.JsonMethods._
/**
 * Created by shashidharsreddy on 2/26/16.
 */

/**
 * {
  "name"      :"Shashi",
  "address"   :{
                "street" : "Alpharetta",
                "city"   : "Atlanta"
                },
  "children" : [{
                 "name" : "Chinni",
                 "age" : "5",
                 "birthdate":"2016-09-10"
                },{
                  "name" : "Bujji",
                  "age" : "10"

                 }]
}
 */



case class Address  (street:String, city:String)
case class Children (name:String,age:Int,birthdate:Option[java.util.Date])
case class Person   (name:String,address:Address,children:List[Children])

object JsonSamples extends App{
  implicit val formats= DefaultFormats



  val file=Source.fromFile("/Users/shashidharsreddy/Scala-Utils/src/main/resources/sampleJson.json").mkString
  val parsed = parse(file)
  val extracted =parsed.extract[Person]
  println(extracted)

  val add:Address=extracted.address
           println(add.city + " " + add.street)
  val children:List[Children] =extracted.children

    children.foreach(p => {

      println("Child Name :"+p.name +"\n Age: " + p.age + " "+ "\n DOB :"+ p.birthdate +"\n")

    })


}







