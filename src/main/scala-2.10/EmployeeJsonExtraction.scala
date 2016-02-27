import scala.io.Source
import org.json4s._
import org.json4s.jackson.JsonMethods._


case class EmployeeDepartments(DptId:String,DptName :String)
case class EmployeeAddresses(City:String,State:String)
case class Employee(employeeName:String,employeeId:String,employeeDepartments:List[EmployeeDepartments],employeeAddresses:List[EmployeeAddresses])
case class Employees(employees:List[Employee])





object EmployeeJsonExtraction extends App{


   implicit val format= DefaultFormats


  val jsonString=Source.fromFile("/Users/shashidharsreddy/Scala-Utils/src/main/resources/employeeDetails.json").mkString
  val parsed=parse(jsonString).extract[Employees]
 // println(parsed)

   if (parsed.isInstanceOf[Employees]) {
     val empees: Employees = parsed.asInstanceOf[Employees]

     empees.employees.foreach(p => {
       val empName = p.employeeName
       val empId = p.employeeId
       println("Employee Name : " + empName + " Employee Id : " + empId + "\n")
       val empDepts: List[EmployeeDepartments] = p.employeeDepartments
       empDepts.foreach(d => println(" Department Id: " + d.DptId + " Department Name : " + d.DptName))
       val empAddss: List[EmployeeAddresses] = p.employeeAddresses
       empAddss.foreach(a => println("City: " + a.City + " State : " + a.State))
       println("================================================================")

     }




     )

   }


}



