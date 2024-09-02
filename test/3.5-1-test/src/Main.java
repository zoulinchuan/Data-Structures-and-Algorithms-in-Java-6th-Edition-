/**
 * @Author zoulinchuan
 * @Date 2024年09月02日 星期一 22:08
 * @description: ${description}
 */
public class Main {
    public static void main(String[] args) {
        MyLinkedList<Object> list = new MyLinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        System.out.println("indexOf:" + list.indexOf(3));

        System.out.println("remove: " + list.remove(3));

        MyLinkedList<Object>.Node node = list.header;
        while (node != null) {
            System.out.println(node.getData());
            node = node.getNext();
        }
    }
}