public class IfStatement {
    public static void main(String[] args) {
        boolean isBluetoothEnabled = false;
        int fileSent = 3;

        if(isBluetoothEnabled){
            // Send File
            fileSent++;
            System.out.println("File sent");
        } else {
            System.out.println("Please turn on the bluetooth to start transfer");
        }

        System.out.println(isBluetoothEnabled);
        System.out.println(fileSent);
    }
}
