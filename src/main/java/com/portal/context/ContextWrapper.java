package com.portal.context;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.context.WebApplicationContext;

/**
 * 
 * @author Wang Beichen
 * @date 2014-1-16
 * @version 1.0
 */
public class ContextWrapper {

  private WebApplicationContext wac = null;

  public ContextWrapper(WebApplicationContext wac) {
    this.setWac(wac);

    // dictService = (DictService) wac.getBean("dictService");

  }

  public Map<String, Object> getMetadata() throws Exception {
    Map<String, Object> metaMap = new HashMap<String, Object>();
    // metaMap.put(Constants.MetaData.GRADE, dictService.findByType(Constants.MetaData.GRADE));

    /*
     * int cityIndex = 0, areaIndex = 0;
     * 
     * Iterator<AdministrativeDistrict> cityIt = cities.iterator(); while(cityIt.hasNext()) {
     * AdministrativeDistrict city = cityIt.next(); List<AdministrativeDistrict> children = new
     * ArrayList<AdministrativeDistrict>(); AdministrativeDistrict area = areas.get(areaIndex);
     * map.put(area.getCode(), area); while( area.getParentCode() == city.getCode() ) {
     * children.add(area); areaIndex++; if( areaIndex >= areas.size() ) { break; } area =
     * areas.get(areaIndex); map.put(area.getCode(), area); } city.setChildren(children);
     * cityList.add(city); map.put(city.getCode(), city); }
     * 
     * Iterator<AdministrativeDistrict> provinceIt = provinces.iterator();
     * while(provinceIt.hasNext()) { AdministrativeDistrict province = provinceIt.next();
     * List<AdministrativeDistrict> children = new ArrayList<AdministrativeDistrict>();
     * AdministrativeDistrict city = cityList.get(cityIndex); while( city.getParentCode() ==
     * province.getCode() ) { if( "市辖区".equals(city.getName()) ) { cityIndex++; if( cityIndex >=
     * cityList.size() ) { break; } city = cityList.get(cityIndex); continue; } children.add(city);
     * cityIndex++; if( cityIndex >= cityList.size() ) { break; } city = cityList.get(cityIndex); }
     * province.setChildren(children); provinceList.add(province); map.put(province.getCode(),
     * province); }
     */
    // Set<Integer> set = map.keySet();
    // Iterator<Integer> it2 = set.iterator();
    // while (it2.hasNext()) {
    // Integer code = it2.next();
    // if (map.get(code).getType() == AppType.AdministrativeDistrict.TYPE_PROVINCE) {
    // provinceList.add(map.get(code));
    // } else if (map.get(code).getType() == AppType.AdministrativeDistrict.TYPE_CITY) {
    // cityList.add(map.get(code));
    // }
    // }
    // Collections.sort(provinceList);
    // Collections.sort(cityList);
    // metaMap.put(Constants.MetaData.PROVINCE_LIST, provinceList);
    // metaMap.put(Constants.MetaData.CITY_LIST, cityList);
    // metaMap.put(Constants.MetaData.AREA_LIST, areas);
    // metaMap.put(Constants.MetaData.ADMINISTRATIVE_DISTRICT_MAP, map);
    return metaMap;
  }

  public WebApplicationContext getWac() {
    return wac;
  }

  public void setWac(WebApplicationContext wac) {
    this.wac = wac;
  }
}
