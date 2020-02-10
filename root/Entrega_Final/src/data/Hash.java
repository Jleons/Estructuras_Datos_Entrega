

package data;
import java.util.ArrayList;

    
public class Hash<String,Usuario>{
    private ArrayList<HashNode<String,Usuario>> arrayHash;
    private int numCasillas;
    private int size;
    
    class HashNode<String,Usuario> {
   String cedula;
   Usuario usuario;
   
   HashNode<String,Usuario> next;
   public HashNode(String llave,Usuario valor){
        this.cedula = llave;
        this.usuario = valor;
    }
}
    public Hash(){
        arrayHash = new ArrayList<>();
        numCasillas = 10;
        size = 0;
        for (int i = 0; i < numCasillas; i++) {
            arrayHash.add(null);
        }
    }
    
    public int size(){return size;}
    
    public boolean isEmpty(){return size() ==0;}
    
    private int getIndex(String llave){
        int hashCode = llave.hashCode();
        if(hashCode<0)
            hashCode*=-1;
        int index = hashCode % numCasillas;
        return index;
    }
    
    public Usuario remove(String llave){
        int bucketIndex = getIndex(llave);
        HashNode<String,Usuario> head = arrayHash.get(bucketIndex);
        HashNode<String,Usuario> prev = null;
        while (head != null){
            if(head.cedula.equals(llave))
                break;
            
            prev = head;
            head = head.next;
        }
        if(head == null)
            return null;
        
        size--;
        if(prev != null)
            prev.next = head.next;
        else
            arrayHash.set(bucketIndex, head.next);
        return head.usuario;
    }
    
    public boolean containsKey(String cedula){
        int bucketIndex = getIndex(cedula);
        HashNode<String,Usuario> head = arrayHash.get(bucketIndex);
        while(head != null){
            if(head.cedula.equals(cedula))
                return true;
            head=head.next;
        }
        return false;
    }
    
    public Usuario get(String llave){
        int bucketIndex = getIndex(llave);
        HashNode<String,Usuario> head = arrayHash.get(bucketIndex);
        while(head != null){
            if(head.cedula.equals(llave))
                return head.usuario;
            head=head.next;
        }
        return null;
    }
    public void add(String cedula,Usuario usuario){
        int bucketIndex = getIndex(cedula);
        HashNode<String,Usuario> head = arrayHash.get(bucketIndex);
        while(head != null){
            if(head.cedula.equals(cedula)){
                head.usuario = usuario;
                return;
            }
            head = head.next;
        }
        size++;
        head = arrayHash.get(bucketIndex);
        HashNode<String,Usuario> newNode = new HashNode<>(cedula,usuario);
        newNode.next = head;
        arrayHash.set(bucketIndex, newNode);
        
        double loadFactor = (1.0*size)/numCasillas;
        if(loadFactor >= 0.7){
            ArrayList<HashNode<String,Usuario>> temp = arrayHash;
            arrayHash = new ArrayList<>();
            numCasillas = 2*numCasillas;
            size = 0;
            for (int i = 0; i < numCasillas; i++) {
                arrayHash.add(null);
            }
            for (HashNode<String,Usuario> headNode:temp) {
                while(headNode != null){
                    add(headNode.cedula, headNode.usuario); 
                    headNode = headNode.next;
                }
            }
        }
    }
}

