public class MagazineRack {
    public static void main(String[] args) {
        MagazineList rack = new MagazineList();

        rack.add(new Magazine("Time"));
        rack.add(new Magazine("Woodworking Today"));
        rack.add(new Magazine("Nature"));
        rack.add(new Magazine("Science"));
        rack.add(new Magazine("Communications of the ACM"));

        System.out.println(rack);
    }
}
