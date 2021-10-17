'''
Se tienen 2 tipos de "familia". La familia Google y la familia Microsoft. Cada familia tiene el producto Mail y el producto CloudStorage, por lo qie aplicando polimorfismo se puede crear implementaciones específicas para cada producto
'''

public interface CloudStorage {
    String show();
}

public class GoogleCloudStorage implements CloudStorage {
    @Override
    public String show() {
        return "Show Google Cloud info"
    }
}

public class MicrosoftCloudStorage implements CloudStorage {
    @Override
    public String show() {
        return "Show Microsoft Cloud info"
    }
}


public interface Mail {
    String show();
}

public class GoogleMail implements Mail {
    @Override
    public String show() {
        return "Show Google Main info"
    }
}

public class MicrosoftMail implements Mail {
    @Override
    public String show() {
        return "Show Microsoft Main info"
    }
}