package uniquecollection;

import java.util.Collection;
import java.util.*;

public class MyFullNameHelper implements FullNameHelper
{
    @Override
    public Collection<FullName> getUnqiueFullNames(Collection<FullName> fullNames)
    {
        return new HashSet<FullName>(fullNames);
    }

    public static class MyFullName implements FullName
    {
        private final String firstName;
        private final String lastName;
        public boolean equals(Object o){
        	boolean equals=false;
        	if(o!=null&&o instanceof MyFullName){
        		MyFullName fullname=(MyFullName)o;
        		equals=this.firstName.equals(fullname.getFirstName())&&
        				this.lastName.equals(fullname.getLastName());
        	}
        	return equals;
        }
        public int hashCode(){
        	String fullname=this.firstName+" "+this.lastName;
        	return fullname.hashCode();
        }
        public MyFullName(String firstName, String lastName)
        {
            this.firstName = firstName;
            this.lastName = lastName;
        }

        public String getFirstName()
        {
            return this.firstName;
        }

        public String getLastName()
        {
            return this.lastName;
        }
    }
}
