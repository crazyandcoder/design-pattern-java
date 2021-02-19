package design_pattern.bridge;

public class RefineAbstraction extends Abstraction {

    public RefineAbstraction(Implementor mImp) {
        super(mImp);
    }

    @Override
    public void operation() {
        mImp.operationImpl();
    }
}
