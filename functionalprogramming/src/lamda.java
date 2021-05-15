public class lamda {
    public static void main(String[] args) {
        finterface obj = new finterface() {
            @Override
            public void greet(String name) {
                System.out.println("hi there "+name);
            }
        };
        obj.greet("vamsi");

        finterface obj1 = (String name) -> {
            System.out.println("hihi"+name);
        };
obj1.greet("vk");
    }
}
