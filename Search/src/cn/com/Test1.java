package cn.com;

public class Test1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashTable hashTable=new HashTable(12);
		hashTable.insertHash(12);
		hashTable.insertHash(67);
		hashTable.insertHash(56);
		hashTable.insertHash(16);
		hashTable.insertHash(25);
		hashTable.insertHash(37);
		hashTable.insertHash(22);
		hashTable.insertHash(29);
		hashTable.insertHash(15);
		hashTable.insertHash(47);
		hashTable.insertHash(48);
		hashTable.insertHash(34);

		System.out.println(hashTable.searchHash(12));
		System.out.println(hashTable.searchHash(67));
		System.out.println(hashTable.searchHash(56));
		System.out.println(hashTable.searchHash(16));
		System.out.println(hashTable.searchHash(25));
		System.out.println(hashTable.searchHash(37));
		System.out.println(hashTable.searchHash(22));
		System.out.println(hashTable.searchHash(29));
		System.out.println(hashTable.searchHash(15));
		System.out.println(hashTable.searchHash(47));
		System.out.println(hashTable.searchHash(48));
		System.out.println(hashTable.searchHash(34));
	}

}
