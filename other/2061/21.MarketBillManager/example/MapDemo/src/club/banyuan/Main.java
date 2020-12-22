package club.banyuan;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {

  public static void main(String[] args) {

    List<Provider> providers = new ArrayList<>();
    providers.add(new Provider(1, "p1"));
    providers.add(new Provider(2, "p2"));
    providers.add(new Provider(3, "p3"));
    providers.add(new Provider(4, "p4"));
    providers.add(new Provider(5, "p5"));

    List<Bill> bills = new ArrayList<>();

    Map<Integer, String> idNameMap = new HashMap<>();
    for (Provider provider : providers) {
      idNameMap.put(provider.getId(), provider.getName());
    }

    for (Bill bill : bills) {
      int providerId = bill.getProviderId();
      bill.setProviderName(idNameMap.get(providerId));
    }
  }
}
