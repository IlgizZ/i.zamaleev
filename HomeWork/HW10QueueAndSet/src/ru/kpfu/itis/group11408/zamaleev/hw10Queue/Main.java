package ru.kpfu.itis.group11408.zamaleev.hw10Queue;

public class Main {

	public static void main(String[] args) {
		
		Faculty itis = new Faculty(10, "ITIS");
		Faculty bmk = new Faculty(10, "BMK");
		Faculty kpfuFaculty = new Faculty(10, "kpfuFaculty");
		MedicineQueue medicineQueue = new MedicineQueue(9);
		for (int i = 0; i < medicineQueue.getSize(); i++) {
			int r = (int)(Math.random() * 3);
			switch (r) {
			case 0:
				medicineQueue.offer(itis.getIllStudent());
				break;
			case 1:
				medicineQueue.offer(bmk.getIllStudent());
				break;
			default:
				medicineQueue.offer(kpfuFaculty.getIllStudent());
				break;
			}
		}
		for (int i = 0; i < medicineQueue.getSize(); i++) {
			System.out.println(medicineQueue.poll() + " is discharged.");
		}
	}

}
