import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.Comparator;

public class ZipArchivator {

	class EntryComparator implements Comparator<MyIntEntry> {

		@Override
		public int compare(MyIntEntry o1, MyIntEntry o2) {
			if (o1 == null) {
				if (o1 == o2) {
					return 0;
				} else {
					return -1;
				}
			}
			if (o2 == null) {
				return 1;
			}
			return o1.getValue() - o2.getValue();
		}

	}

	class MyIntEntry {
		private char key;
		private int value;
		private MyIntEntry left;
		private MyIntEntry right;
		private boolean isChar = false;
		private String byteString;

		public MyIntEntry getLeft() {
			return left;
		}

		public void setLeft(MyIntEntry left) {
			this.left = left;
		}

		public MyIntEntry getRight() {
			return right;
		}

		public void setRight(MyIntEntry right) {
			this.right = right;
		}

		public boolean isChar() {
			return isChar;
		}

		public void setChar(boolean isChar) {
			this.isChar = isChar;
		}

		public MyIntEntry(char key, int value, boolean isChar) {
			this.key = key;
			this.value = value;
			this.isChar = true;
		}

		public MyIntEntry(int value) {
			super();
			this.value = value;
		}

		public char getKey() {
			return key;
		}

		public void setKey(char key) {
			this.key = key;
		}

		public int getValue() {
			return value;
		}

		public String getByteString() {
			return byteString;
		}

		public void setByteString(String byteString) {
			this.byteString = byteString;
		}

		public void setValue(int value) {
			this.value = value;
		}

	}

	class MyByteEntry {
		private char key;
		private byte[] value;

		public MyByteEntry(char key, byte value[]) {
			this.key = key;
			this.value = value;
		}

		public MyByteEntry(char key, char value[]) {
			this.key = key;
			this.value = new byte[value.length];
			for (int i = 0; i < value.length; i++) {
				this.value[i] = (byte) (value[i] - '0');
			}
		}

		public char getKey() {
			return key;
		}

		public void setKey(char key) {
			this.key = key;
		}

		public byte[] getValue() {
			return value;
		}

		public void setValue(byte[] value) {
			this.value = value;
		}

	}

	public void getFileBytes(String fileName) {
		if (fileName == null) {
			try {
				throw new ZipArchivateException("File name can't be null");
			} catch (ZipArchivateException e) {
				e.printStackTrace();
			}
		}
		MyIntEntry[] treeAr = new MyIntEntry[0];
		MyByteEntry[] result = {};
		String text = "";
		try (InputStream is = new FileInputStream(fileName)) {
			int i;
			while ((i = is.read()) != -1) {
				treeAr = addChar((char) i, treeAr);
				text += (char) i;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		Arrays.sort(treeAr, new EntryComparator());
		result = getByteArr(treeAr);
		for (MyByteEntry element: result){
			System.out.print(element.getKey() + ": ");
			for (byte b: element.getValue()){
				System.out.print(b);
			}
			System.out.println();
		}
		File f = new File("2.izip");
		try (OutputStream os = new FileOutputStream(f)) {
			//write file name
			for (MyByteEntry element : result) {
				os.write(element.getKey());
				for (byte b : element.getValue()) {
					os.write(b);
				}
			}
			os.write('$');
			for (int i = 0; i < text.length(); i++) {
				char c = text.charAt(i);
				int j = 0;
				byte outByte = 0;
				while (result[j].getKey() != c) {
					j++;
				}
				/*if (i + 1 < text.length()){
					int k = 0;
					while (result[k].getKey() != text.charAt(i + 1)) {
						k++;
					}
					if (result[j].getValue().length + result[k].getValue().length <= 8){
						for (byte b : result[j].getValue()) {
							//summ bytes
							outByte = (byte)(outByte << 1 + 1);
						}
						outByte = (byte)(outByte << (8 - result[j].getValue().length));
					}
				}*/

				for (byte b : result[j].getValue()) {
					os.write(b);
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private MyByteEntry[] getByteArr(MyIntEntry[] arr) {
		for (int i = 0; i < arr.length - 1; i++) {
			unitTwoLast(i, arr);
		}
		MyByteEntry[] result = new MyByteEntry[arr.length];
		String code = "";
		for (int i = 0; i < result.length; i++) {
			MyIntEntry tmpEntry = findChar(arr[arr.length - 1],
					arr[arr.length - 1], code);
			while (tmpEntry == null) {
				tmpEntry = findChar(arr[arr.length - 1], arr[arr.length - 1],
						code);
			}
			result[i] = new MyByteEntry(tmpEntry.getKey(), tmpEntry
					.getByteString().toCharArray());
		}
		return result;
	}

	private MyIntEntry findChar(MyIntEntry square, MyIntEntry parent,
			String code) {
		MyIntEntry result = null;
		if (square.left != null) {
			code += "0";
			result = findChar(square.left, square, code);
		} else if (square.right != null) {
			code += "1";
			result = findChar(square.right, square, code);
		} else if (square.isChar) {
			square.setByteString(code);
			if (parent.left != null && parent.left.isChar
					&& parent.left.left == null) {
				parent.left = null;
			} else {
				parent.right = null;
			}
			return square;// ****
		} else if (parent.left != null && !parent.left.isChar) {
			parent.left = null;
			return null;
		} else {
			parent.right = null;
			return null;
		}

		return result;
	}

	private void unitTwoLast(int beginIndx, MyIntEntry[] arr) {
		MyIntEntry tmpEntry = new MyIntEntry(arr[beginIndx].getValue()
				+ arr[beginIndx + 1].getValue());
		tmpEntry.setLeft(arr[beginIndx]);
		tmpEntry.setRight(arr[beginIndx + 1]);
		arr[beginIndx] = null;
		arr[beginIndx + 1] = null;
		int i = beginIndx + 2;
		while (i < arr.length && arr[i].getValue() < tmpEntry.getValue()) {
			arr[i - 1] = arr[i];
			i++;
		}
		arr[i - 1] = tmpEntry;
	}

	private MyIntEntry[] addChar(char c, MyIntEntry[] arr) {
		int i = 0;
		while (i < arr.length && arr[i].getKey() != c) {
			i++;
		}
		if (i == arr.length) {
			MyIntEntry[] tmpArr = new MyIntEntry[arr.length + 1];
			for (int j = 0; j < tmpArr.length - 1; j++) {
				tmpArr[j] = arr[j];
			}
			tmpArr[tmpArr.length - 1] = new MyIntEntry(c, 1, true);
			arr = tmpArr;

		} else {
			arr[i].setValue(arr[i].getValue() + 1);
		}
		return arr;
	}
}
