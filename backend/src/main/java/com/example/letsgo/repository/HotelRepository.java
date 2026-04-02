public interface HotelRepository extends JpaRepository<Hotel, Long> {
    List<Hotel> findByLocationContaining(String location); // For searching by location
}