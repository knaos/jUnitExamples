public class Child extends BaseUser {
    public boolean disabled;
    public boolean hasTwins;
    public Parent[] parents;
    public Child[] siblings;
    public String school;

    Child(String name, int age, boolean disabled, boolean hasTwins, Parent[] parents, Child[] siblings, String school) {
        this.disabled = disabled;
        this.age = age;
        this.hasTwins = hasTwins;
        this.parents = parents;
        this.siblings = siblings;
        this.name = name;
        this.school = school;
    }
}
