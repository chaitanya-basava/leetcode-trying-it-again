class ProductOfNumbers {

    private List<Integer> prefixProduct;
    private int size = 0;

    private void init() {
        this.prefixProduct = new ArrayList<>();
        this.prefixProduct.add(1);
        this.size = 0;
    }

    public ProductOfNumbers() {
        this.init();
    }

    public void add(int num) {
        if (num == 0) {
            this.init();
        } else {
            this.prefixProduct.add(this.prefixProduct.get(size++) * num);
        }
    }

    public int getProduct(int k) {
        if (k > this.size) return 0; // indicates that there is a 0 somewhere in the last k numbers
        return this.prefixProduct.get(this.size) / this.prefixProduct.get(this.size - k);
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */
