/**
* 
* @author Nidhi Sharma
* Description: Defines an annotation named "RequestForEnhancement"
*
*/
public @interface RequestForEnhancement {

int id();

String synopsis();

String engineer() default "[unassigned]";

String date() default "[unknown]";

}
