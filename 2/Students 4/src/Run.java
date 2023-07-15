public class Run
{
    public static void main (String args[])
    {
        Students std1 = new Students("sina","hosseinzadeh",9831021,12);
        Students std2 = new Students("reza","hashemi",9831022,6);
        std2.setGrade(16);
        Lab first = new Lab (1,"sunday");
        first.enrollStudent(std1);
        first.enrollStudent(std2);
        first.calculateAvg();
        first.print();
    }
}
