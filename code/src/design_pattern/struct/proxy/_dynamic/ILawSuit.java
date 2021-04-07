package design_pattern.struct.proxy._dynamic;

public interface ILawSuit {
    void prepare();
    void submit(String proof);//提起诉讼
    void defend();//法庭辩护
}
