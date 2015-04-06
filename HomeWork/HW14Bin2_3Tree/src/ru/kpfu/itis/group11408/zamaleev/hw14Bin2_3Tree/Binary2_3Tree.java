package ru.kpfu.itis.group11408.zamaleev.hw14Bin2_3Tree;

/**
 * Created by Ilgiz on 06.04.2015.
 */
public class Binary2_3Tree<K extends Comparable, V> {
    private Element square;
    private int size;

    class Element {
        private K key;
        private K secondKey;
        private V value;
        private V secondValue;
        private Element left;
        private Element mid;
        private Element right;

        public V getSecondValue() {
            return secondValue;
        }

        public void setSecondValue(V secondValue) {
            this.secondValue = secondValue;
        }

        public K getSecondKey() {
            return secondKey;
        }

        public void setSecondKey(K secondKey) {
            this.secondKey = secondKey;
        }

        public K getKey() {
            return key;
        }

        public void setKey(K key) {
            this.key = key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }

        public Element getLeft() {
            return left;
        }

        public void setLeft(Element left) {
            this.left = left;
        }

        public Element getRight() {
            return right;
        }

        public void setRight(Element right) {
            this.right = right;
        }

        public Element getMid() {
            return mid;
        }

        public void setMid(Element mid) {
            this.mid = mid;
        }

        public Element(K key, V value) {
            super();
            this.key = key;
            this.value = value;
        }
    }

    public Binary2_3Tree() {
        square = new Element(null, null);
        size = 0;
    }

    public boolean isEmpty() {
        return size > 0;
    }

    public V get(K key) {
        if (isEmpty()){
            try {
                throw new NullPointerException("Tree is empty!");
            } catch (NullPointerException e){
                e.printStackTrace();
            }
            return null;
        }
        return find(square, new Element(key, null));
    }

    private V find(Element parent, Element element) {
        int i = parent.getKey().compareTo(element.getKey());
        V result = null;
        if (i > 0) {
            if (parent.left == null) {
                result = null;
            } else {
               result = find(parent.left, element);
            }
        } else if (i < 0) {
            if (parent.secondKey != null){
                i = parent.getSecondKey().compareTo(element.getKey());
                if (i > 0) {
                    if (parent.mid == null) {
                        result = null;
                    } else {
                        result = find(parent.mid, element);
                    }
                } else if (i < 0) {
                    if (parent.right == null) {
                        result = null;
                    } else {
                        result = find(parent.right, element);
                    }
                } else result = parent.getSecondValue();
            } else {
                if (parent.right == null) {
                    result = null;
                } else {
                    result = find(parent.right, element);
                }
            }
        } else {
            result = parent.getValue();
        }
        return result;
    }

    public void put(K key, V value) { //not work
        if (isEmpty()) {
            square.setKey(key);
            square.setValue(value);
            size++;
        } else {
            Element place = findPlace(square, new Element(key, value));
        }

    }

    private Element findPlace(Element parent, Element element) {
        int i = parent.getKey().compareTo(element.getKey());
        Element result = null;
        if (i > 0) {
            if (parent.left == null) {
                result = parent;
            } else {
                result = findPlace(parent.left, element);
            }
        } else if (i < 0) {
            if (parent.secondKey != null){
                i = parent.getSecondKey().compareTo(element.getKey());
                if (i > 0) {
                    if (parent.mid == null) {
                        result = null;
                    } else {
                        result = findPlace(parent.mid, element);
                    }
                } else if (i < 0) {
                    if (parent.right == null) {
                        result = null;
                    } else {
                        result = findPlace(parent.right, element);
                    }
                }// else result = parent.getSecondValue();
            } else {
                if (parent.right == null) {
                    result = parent;
                } else {
                    result = findPlace(parent.right, element);
                }
            }
        } else {
            parent = element;
        }
        return result;
    }
}

