public class EnumValidator {


    public static boolean validateComponentType(String componentTypeStr){

        for(ComponentType componentType : ComponentType.values()){ // Returns an array containing the constants of this enum type, in the order they're declared.
            if(componentType.name().equals(componentTypeStr)){ // Za pomoca metody name() mozna porownywac enum z podanym wzorcem(regexem)
                return true;
            }
        }
        return false;
    }

}
