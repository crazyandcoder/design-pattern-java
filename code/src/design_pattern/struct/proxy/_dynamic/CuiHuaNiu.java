package design_pattern.struct.proxy._dynamic;

public class CuiHuaNiu implements ILawSuit {
    @Override
    public void prepare() {
        System.out.println(String.format("牛翠花在准备材料"));
    }

    @Override
    public void submit(String proof) {
        System.out.println(String.format("老板欠薪跑路，证据如下：%s",proof));
    }

    @Override
    public void defend() {
        System.out.println(String.format("铁证如山，%s还钱","马旭"));
    }
}
