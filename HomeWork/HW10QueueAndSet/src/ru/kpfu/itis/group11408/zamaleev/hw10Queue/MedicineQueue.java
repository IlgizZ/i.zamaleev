package ru.kpfu.itis.group11408.zamaleev.hw10Queue;

public class MedicineQueue implements MyQueue<Student>{
	private Student[] array;
	private int begin = -1;
	private int end = -1;
	private int size;
	
	public int getSize() {
		return size;
	}

	public MedicineQueue(int queueLength) {
		this.size = queueLength;
		this.array = new Student[queueLength];
	}

	@Override
	public void offer(Student t) {
		if (isEmpty()){
			begin = 0;
			end = 0;
			array[begin] = t;
		} else if (size() + 1 > array.length){ 
			try {
				throw new Exception("Queue is overflow");
			} catch (Exception e) {
				e.printStackTrace();
			}				
		}else {
			end++;
			if (end > array.length){
				end = 0;
			}
			array[end] = t;
		}
	}

	@Override
	public Student peek() {
		return array[begin];
	}

	@Override
	public Student poll() {
		if (begin == -1){
			try {
				throw new Exception("Queue is empty!!!");
			} catch (Exception e) {
				e.printStackTrace();
			}	
		}
		Student tmp = array[begin];
		array[begin] = null;
		if (end == begin){
			begin = end = -1;
		} else {
			begin++;
		}		
		if (begin == array.length){
			begin = 0;
		}
		
		return tmp;
	}

	@Override
	public int size() {
		if (begin == -1){
			return 0;
		}
		if (begin > end){
			return end + 1 + begin - array.length;
		}
		return end - begin + 1;
	}

	@Override
	public boolean isEmpty() {
		return begin == -1;
	}

}
