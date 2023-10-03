package com.flight.management;

import com.flight.management.model.flight.BusinessFlight;
import com.flight.management.model.flight.EconomyFlight;
import com.flight.management.model.flight.Flight;
import com.flight.management.model.flight.PremiumFlight;
import com.flight.management.model.passenger.Passenger;
import org.junit.jupiter.api.*;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class AirportTest {

    @Nested
    @DisplayName("Given there is an economy flight ")
    class EconomyFlightTest {

        private Flight economyFlight;

        private Passenger mike;

        private Passenger john;

        @BeforeEach
        void setUp() {
            economyFlight = new EconomyFlight("1");
            mike = new Passenger("Mike", false);
            john = new Passenger("John", true);
        }

        @Nested
        @DisplayName("When we have a regular passenger")
        class RegularPassenger {

            @Test
            @DisplayName("Then we can add and remove him from an economy flight")
            void testEconomyFlightWithRegularPassenger() {
                assertAll(
                        "Verify all conditions for a regular passenger and an economy flight",
                        () -> assertEquals("1", economyFlight.getId()),
                        () -> assertTrue(economyFlight.addPassenger(mike)),
                        () -> assertEquals(1, economyFlight.getAllPassengers().size()),
                        () -> assertEquals("Mike", new ArrayList<>(economyFlight.getAllPassengers()).get(0).getName()),

                        () -> assertTrue(economyFlight.removePassenger(mike)),
                        () -> assertEquals(0, economyFlight.getAllPassengers().size()));
            }

            @DisplayName("Then we can't add him to an economy flight more than once")
            @RepeatedTest(5)
            void testEconomyFlightWithRegularPassengerAddedOnlyOnce(RepetitionInfo repetitionInfo) {

                for (int i = 0; i < repetitionInfo.getCurrentRepetition(); i++)
                    economyFlight.addPassenger(mike);

                assertAll(
                        "Verify a regular passenger can be added to an economy flight only once",
                        () -> assertEquals(1, economyFlight.getAllPassengers().size()),
                        () -> assertTrue(economyFlight.getAllPassengers().contains(mike)),
                        () -> assertEquals("Mike", new ArrayList<>(economyFlight.getAllPassengers()).get(0).getName())
                );

            }
        }

        @Nested
        @DisplayName("When we have a VIP passenger")
        class VipPassenger {

            @Test
            @DisplayName("Then we can add him but can't remove him from an economy flight")
            void testEconomyFlightWithVipPassenger() {
                assertAll(
                        "Verify all conditions for a vip passenger and an economy flight",
                        () -> assertEquals("1", economyFlight.getId()),
                        () -> assertTrue(economyFlight.addPassenger(john)),
                        () -> assertEquals(1, economyFlight.getAllPassengers().size()),
                        () -> assertEquals("John", new ArrayList<>(economyFlight.getAllPassengers()).get(0).getName()),

                        () -> assertFalse(economyFlight.removePassenger(john)),
                        () -> assertEquals(1, economyFlight.getAllPassengers().size())
                );
            }

        }

    }

    @Nested
    @DisplayName("Given there is a business flight ")
    class BusinessFlightTest {

        private Flight businessFlight;

        private Passenger regularPassenger;

        private Passenger vipPassenger;

        @BeforeEach
        void setUp() {
            businessFlight = new BusinessFlight("1");
            regularPassenger = new Passenger("Mike", false);
            vipPassenger = new Passenger("John", true);
        }

        @Nested
        @DisplayName("When we have a regular passenger")
        class RegularPassenger {

            @Test
            @DisplayName("Then we can't add or remove him from a business flight")
            void testBusinessFlightWithRegularPassenger() {
                assertAll(
                        "Verify all conditions for a regular passenger and a business flight",
                        () -> assertFalse(businessFlight.addPassenger(regularPassenger)),
                        () -> assertEquals(0, businessFlight.getAllPassengers().size()),
                        () -> assertFalse(businessFlight.removePassenger(regularPassenger)),
                        () -> assertEquals(0, businessFlight.getAllPassengers().size()));
            }

        }

        @Nested
        @DisplayName("When we have a vip passenger")
        class VipPassenger {

            @Test
            @DisplayName("Then we can add him but cannot remove him from a business flight")
            void testBusinessFlightWithVipPassenger() {
                assertAll(
                        "Verify all conditions for a vip passenger and a business flight",
                        () -> assertEquals(0, businessFlight.getAllPassengers().size()),
                        () -> assertTrue(businessFlight.addPassenger(vipPassenger)),
                        () -> assertEquals(1, businessFlight.getAllPassengers().size()),
                        () -> assertEquals("John", new ArrayList<>(businessFlight.getAllPassengers()).get(0).getName()),
                        () -> assertFalse(businessFlight.removePassenger(vipPassenger)),
                        () -> assertEquals(1, businessFlight.getAllPassengers().size()));
            }

        }

    }

    @Nested
    @DisplayName("Given there is a premium flight")
    class PremiumFlightTest {

        private Flight premiumFlight;

        private Passenger regularPassenger;

        private Passenger vipPassenger;

        @BeforeEach
        void setUp() {
            premiumFlight = new PremiumFlight("1");
            regularPassenger = new Passenger("Mike", false);
            vipPassenger = new Passenger("John", true);
        }

        @Nested
        @DisplayName("When we have a regular passenger")
        class RegularPassenger {

            @Test
            @DisplayName("Then we can't add or remove him from a premium flight")
            void testRegularPassengerWithPremiumFlight() {
                assertAll(
                        "Verify all conditions for a regular passenger and a premium flight",
                        () -> assertFalse(premiumFlight.addPassenger(regularPassenger)),
                        () -> assertEquals(0, premiumFlight.getAllPassengers().size()),
                        () -> assertFalse(premiumFlight.removePassenger(regularPassenger)),
                        () -> assertEquals(0, premiumFlight.getAllPassengers().size())
                );
            }

        }

        @Nested
        @DisplayName("When we have a vip passenger")
        class VipPassenger {

            @Test
            @DisplayName("Then we can add and remove him from a premium flight")
            void testPremiumFlightForVipPassenger() {
                assertAll(
                        "Verify all conditions for a VIP passenger and a premium flight",
                        () -> assertTrue(premiumFlight.addPassenger(vipPassenger)),
                        () -> assertEquals(1, premiumFlight.getAllPassengers().size()),
                        () -> assertTrue(premiumFlight.removePassenger(vipPassenger)),
                        () -> assertEquals(0, premiumFlight.getAllPassengers().size())
                );
            }
        }

    }

}